package com.cryptal.ark.arkcreditmanager.article.page;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.page.button.batch.CreateOperation;
import cn.com.gome.page.button.column.DeleteOperation;
import cn.com.gome.page.button.column.EditOperation;
import cn.com.gome.page.core.PageConfig;
import cn.com.gome.page.core.PageContext;
import cn.com.gome.page.core.PageService;
import cn.com.gome.page.field.LongFieldDefinition;
import cn.com.gome.page.field.StringFieldDefinition;
import cn.com.gome.page.field.domain.PageDomainProvider;
import cn.com.gome.page.field.validator.IntFieldDefinition;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cryptal.ark.interfaze.article.domain.ArticleCategory;
import com.cryptal.ark.interfaze.article.dubbo.ArticleCategoryDubboService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleCategoryPageService extends PageService<ArticleCategory,Long> implements PageDomainProvider<ArticleCategory> {

    @Reference(group = "ark-credit-service")
    private ArticleCategoryDubboService articleCategoryDubboService;

    @Override
    public PageObject<ArticleCategory> paged(SearchFilter searchFilter) {
        return articleCategoryDubboService.page(searchFilter);
    }

    @Override
    protected PageConfig initializePageConfig(PageContext pageContext) {
        PageConfig pageConfig = new PageConfig(pageContext)
                .withDomainName("article_category")
                .withDomainClass(ArticleCategory.class)
                .withDomainChineseName("栏目")
                .withFieldDefinitions(
                        new LongFieldDefinition("id", "ID"),
                        new StringFieldDefinition("name", "名称").required(),
                        new StringFieldDefinition("identifier", "唯一标识").required(),
                        new IntFieldDefinition("sortNo", "排序").required()
                )
                .withTableColumnDefinitions(
                        "id_10",
                        "name_30",
                        "identifier_20",
                        "sortNo_10",
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
                        "identifier_rw",
                        "sortNo_rw"
                );
        return pageConfig;
    }

    @Override
    public ArticleCategory get(String id) {
        return articleCategoryDubboService.get(Long.parseLong(id));
    }

    @Override
    public ArticleCategory get(SearchFilter searchFilter) {
        return articleCategoryDubboService.get(searchFilter);
    }

    @Override
    public void saveOrUpdate(ArticleCategory articleCategory) {
        articleCategoryDubboService.saveOrUpdate(articleCategory);
    }

    @Override
    public void delete(ArticleCategory articleCategory) {
        articleCategoryDubboService.delete(articleCategory.getId());
    }

    @Override
    public Object findByReferId(String referId) {
        return articleCategoryDubboService.get(Long.parseLong(referId));
    }

    @Override
    public String getDomainName() {
        return "article_category";
    }

    @Override
    public String getDomainChineseName() {
        return "栏目";
    }

    @Override
    public String getDisplayFieldName() {
        return "name";
    }

    @Override
    public List<ArticleCategory> findAll() {
        return articleCategoryDubboService.findAll();
    }
}
