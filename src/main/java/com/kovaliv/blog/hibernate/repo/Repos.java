package com.kovaliv.blog.hibernate.repo;

public class Repos {

    private static UserRepo userRepo;

    private static ArticleRepo articleRepo;

    public static void setArticleRepo(ArticleRepo articleRepo) {
        Repos.articleRepo = articleRepo;
    }

    public static ArticleRepo getArticleRepo() {
        if (articleRepo == null) {
            articleRepo = new ArticleRepoHibernate();
        }
        return articleRepo;
    }

    public static void setUserRepo(UserRepo userRepo) {
        Repos.userRepo = userRepo;
    }

    public static UserRepo getUserRepo() {
        if (userRepo == null) {
            userRepo = new UserRepoHibernate();
        }
        return userRepo;
    }
}
