package org.example;

public class Main {
    public static void main(String[] args) {
        String url1 = "https://github.com/Dellout4/project_tink/blob/main/.gitignore";
        Link link1 = LinkParser.parse(url1);
        System.out.println(link1.parse()); // Выводит пару пользователь / репозиторий

        String url2 = "https://stackoverflow.com/questions/5905896/intellij-inspection-gives-cannot-resolve-symbol-but-still-compiles-code";
        Link link2 = LinkParser.parse(url2);
        System.out.println(link2.parse()); // Выводит id

        String url3 = "https://ugatu.su/";
        Link link3 = LinkParser.parse(url3);
        System.out.println(link3.parse()); // Выводит null
    }
}
