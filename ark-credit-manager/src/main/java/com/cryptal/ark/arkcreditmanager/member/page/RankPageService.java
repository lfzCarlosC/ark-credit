package com.cryptal.ark.arkcreditmanager.member.page;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.page.button.batch.CreateOperation;
import cn.com.gome.page.button.column.DeleteOperation;
import cn.com.gome.page.button.column.EditOperation;
import cn.com.gome.page.button.column.NewPageOperation;
import cn.com.gome.page.core.PageConfig;
import cn.com.gome.page.core.PageContext;
import cn.com.gome.page.core.PageService;
import cn.com.gome.page.field.DisplayStringFieldDefinition;
import cn.com.gome.page.field.LongFieldDefinition;
import cn.com.gome.page.field.domain.PageDomainProvider;
import cn.com.gome.page.field.validator.IntFieldDefinition;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cryptal.ark.interfaze.member.domain.Rank;
import com.cryptal.ark.interfaze.member.dubbo.RankDubboService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RankPageService extends PageService<Rank,Long> implements PageDomainProvider<Rank> {

    @Reference(group = "ark-credit-service")
    private RankDubboService rankDubboService;

    @Override
    public PageObject<Rank> paged(SearchFilter searchFilter) {
        return rankDubboService.page(searchFilter);
    }

    @Override
    protected PageConfig initializePageConfig(PageContext pageContext) {
        return new PageConfig(pageContext)
                .withDomainName("rank")
                .withDomainClass(Rank.class)
                .withDomainChineseName("会员等级")
                .withFieldDefinitions(
                        new LongFieldDefinition("id", "ID"),
                        new DisplayStringFieldDefinition("name", "名称").required(),
                        new IntFieldDefinition("rebatePercentLevel1", "一级佣金").required(),
                        new IntFieldDefinition("rebatePercentLevel2", "二级佣金").required(),
                        new IntFieldDefinition("rebatePercentLevel3", "三级佣金").required()
                )
                .withTableColumnDefinitions(
                        "id_10",
                        "name_30",
                        "rebatePercentLevel1_10",
                        "rebatePercentLevel2_10",
                        "rebatePercentLevel3_10",
                        "#operation_30"
                )
                .withTableAction(
                        new CreateOperation()
                )
                .withColumnAction(
                        new NewPageOperation("推送类别设置","/admin/rank_permission/page?rankId=#id#","推送类别设置","id"),
                        new EditOperation(),
                        new DeleteOperation()
                )
                .withFormItemDefinition(
                        "name_rw",
                        "rebatePercentLevel1_rw",
                        "rebatePercentLevel2_rw",
                        "rebatePercentLevel3_rw"
                );
    }

    @Override
    public Rank get(String id) {
        return rankDubboService.get(Long.parseLong(id));
    }

    @Override
    public Rank get(SearchFilter searchFilter) {
        return rankDubboService.get(searchFilter);
    }

    @Override
    public void saveOrUpdate(Rank rank) {
        rankDubboService.saveOrUpdate(rank);
    }

    @Override
    public void delete(Rank rank) {
        rankDubboService.delete(rank.getId());
    }

    @Override
    public Rank findByReferId(String referId) {
        return rankDubboService.get(Long.parseLong(referId));
    }

    @Override
    public String getDomainName() {
        return "member_rank";
    }

    @Override
    public String getDomainChineseName() {
        return "等级";
    }

    @Override
    public String getDisplayFieldName() {
        return "name";
    }

    @Override
    public List<Rank> findAll() {
        return rankDubboService.findAll();
    }
}
