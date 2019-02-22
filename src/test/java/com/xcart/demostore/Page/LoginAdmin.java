package com.xcart.demostore.page;

import org.junit.Test;

public class LoginAdmin extends Page {

    @Test
    public void AdminLogin() {
        AdminPage pageAdmin = new AdminPage();

        pageAdmin.login();
    }
}
