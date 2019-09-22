package com.cryptal.ark.arkcreditmanager.member.page;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.page.button.batch.CreateOperation;
import cn.com.gome.page.button.column.DeleteOperation;
import cn.com.gome.page.button.column.EditOperation;
import cn.com.gome.page.core.PageConfig;
import cn.com.gome.page.core.PageContext;
import cn.com.gome.page.core.PageService;
import cn.com.gome.page.field.DisplayStringFieldDefinition;
import cn.com.gome.page.field.LongFieldDefinition;
import cn.com.gome.page.field.validator.IntFieldDefinition;
import com.cryptal.ark.interfaze.member.domain.MemberRank;
import com.cryptal.ark.interfaze.member.dubbo.MemberRankDubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberRankPageService extends PageService<MemberRank,Long> {

    @Autowired
    private MemberRankDubboService memberRankDubboService;

    @Override
    public PageObject<MemberRank> paged(SearchFilter searchFilter) {
        return memberRankDubboService.page(searchFilter);
    }

    @Override
    protected PageConfig initializePageConfig(PageContext pageContext) {
        return new PageConfig(pageContext)
                .withDomainName("member_rank")
                .withDomainClass(MemberRank.class)
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
    public MemberRank get(String id) {
        return memberRankDubboService.get(Long.parseLong(id));
    }

    @Override
    public MemberRank get(SearchFilter searchFilter) {
        return memberRankDubboService.get(searchFilter);
    }

    @Override
    public void saveOrUpdate(MemberRank memberRank) {
        memberRankDubboService.saveOrUpdate(memberRank);
    }

    @Override
    public void delete(MemberRank memberRank) {
        memberRankDubboService.delete(memberRank.getId());
    }
}
