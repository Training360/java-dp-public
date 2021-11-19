package proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArticleServiceTest {

    @Test
    void hasRole() {
        ArticleService articleService = ArticleServiceFactory
                .getArticleServiceProxy(new DefaultArticleService(), new SecurityContext("John Doe", "admin"));
        articleService.saveArticle();
        // No exception!
    }

    @Test
    void hasNoRole() {
        ArticleService articleService = ArticleServiceFactory
                .getArticleServiceProxy(new DefaultArticleService(), new SecurityContext("John Doe", "anonymous"));

        SecurityException e = assertThrows(SecurityException.class,
                articleService::saveArticle);
        assertEquals("No role", e.getMessage());
    }

    @Test
    void acceptAnyRoleForRead() {
        ArticleService articleService = ArticleServiceFactory
                .getArticleServiceProxy(new DefaultArticleService(), new SecurityContext("John Doe", "anonymous"));
        articleService.readArticle();

    }
}
