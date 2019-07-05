package ru.yandex.disk.apiTest;

import org.junit.Test;
import ru.yandex.disk.api.disk.DiskApi;
import ru.yandex.disk.api.models.MetainformationAboutDiskUser;
import ru.yandex.disk.api.models.User;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class DiskApiTest {
    @Test
    public void getMetainformationAboutDiskUserTest() {
        MetainformationAboutDiskUser meta = new MetainformationAboutDiskUser();
//        System.out.println(meta.getUser().getLogin());
        MetainformationAboutDiskUser metainformationAboutDiskUser = new DiskApi()
                .GetAllMetainformationAboutDiskUser();
//        System.out.println(metainformationAboutDiskUser.getMaxFileSize());

        assertEquals(metainformationAboutDiskUser.getUser().getCountry(), "ru");
//        assertEquals(metainformationAboutDiskUser.getUser().getLogin(), "autotest4");
//        assertEquals(metainformationAboutDiskUser.getUser().getDisplayName(), "autotest4");
//        assertEquals(metainformationAboutDiskUser.getUser().getUid(), "476617890");
    }
}

