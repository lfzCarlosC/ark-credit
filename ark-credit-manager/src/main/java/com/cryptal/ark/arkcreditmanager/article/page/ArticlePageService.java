package com.cryptal.ark.arkcreditmanager.article.page;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.page.button.batch.CreateOperation;
import cn.com.gome.page.button.column.DeleteOperation;
import cn.com.gome.page.button.column.EditOperation;
import cn.com.gome.page.core.PageConfig;
import cn.com.gome.page.core.PageContext;
import cn.com.gome.page.core.PageService;
import cn.com.gome.page.field.*;
import cn.com.gome.page.field.validator.IntFieldDefinition;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cryptal.ark.interfaze.article.domain.Article;
import com.cryptal.ark.interfaze.article.dubbo.ArticleDubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticlePageService extends PageService<Article,Long> {

    @Reference(group = "ark-credit-service")
    private ArticleDubboService articleDubboService;

    @Autowired
    private ArticleCategoryPageService articleCategoryPageService;

    @Override
    public PageObject<Article> paged(SearchFilter searchFilter) {
        return articleDubboService.paged(searchFilter);
    }

    @Override
    protected PageConfig initializePageConfig(PageContext pageContext) {
        PageConfig pageConfig = new PageConfig(pageContext)
                .withDomainName("article")
                .withDomainClass(Article.class)
                .withDomainChineseName("文章")
                .withFieldDefinitions(
                        new LongFieldDefinition("id", "ID"),
                        new StringFieldDefinition("name", "名称").required(),
                        new DomainLongFieldDefinition("categoryId", "分类ID",articleCategoryPageService).required(),
                        new ImageFieldDefinition("imagePath", "图片地址",500,200),
                        new IntFieldDefinition("sortNo", "排序").required(),
                        new EditorFieldDefinition("content", "正文")
                )
                .withTableColumnDefinitions(
                        "id_10",
                        "name_25",
                        "categoryId_15",
                        "imagePath_20",
                        "sortNo_10",
                        "#operation_20"
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
                        "categoryId_rw",
                        "imagePath_rw",
                        "sortNo_rw",
                        "content_rw"
                );
        return pageConfig;
    }

    @Override
    public Article get(String id) {
        return articleDubboService.get(Long.parseLong(id));
    }

    @Override
    public Article get(SearchFilter searchFilter) {
        return articleDubboService.get(searchFilter);
    }

    @Override
    public void saveOrUpdate(Article article) {
        articleDubboService.saveOrUpdate(article);
    }

    @Override
    public void delete(Article article) {
        articleDubboService.delete(article.getId());
    }
}
