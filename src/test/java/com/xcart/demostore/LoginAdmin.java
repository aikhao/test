package com.xcart.demostore;

import com.xcart.demostore.page.AdminPage;
import com.xcart.demostore.page.Page;
import org.junit.Test;

public class LoginAdmin extends Page {

    @Test
    public void AdminLogin() {
        AdminPage pageAdmin = new AdminPage();

        pageAdmin.login();
    }
}
