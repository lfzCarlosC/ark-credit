package com.cryptal.ark.arkcreditservice.user;

import static org.mockito.Mockito.when;

import com.cryptal.ark.arkcreditservice.user.domain.Device;
import com.cryptal.ark.arkcreditservice.user.service.DeviceService;
import com.cryptal.ark.arkcreditservice.user.service.impl.DeviceServiceImpl;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cryptal.ark.arkcreditservice.user.dao.UserDao;
import com.cryptal.ark.arkcreditservice.user.domain.User;
import com.cryptal.ark.arkcreditservice.user.request.RegisterUserRequest;
import com.cryptal.ark.arkcreditservice.user.service.UserService;
import com.cryptal.ark.arkcreditservice.user.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private UserService userService = new UserServiceImpl();

    @Mock
    private UserDao userDao;

    private DeviceService deviceService = new DeviceServiceImpl();

    @Mock
    private User user;

    /**
     * 用例一：用户注册
     */
    public void test_user_register() {

        RegisterUserRequest request = new RegisterUserRequest();

        userService.register(request);
    }

    public void test_user_getUserInfo() {
        Long userId = 11L;
        String name = "testUser";
        when(userDao.getOne(userId)).thenReturn(user);
        when(user.getId()).thenReturn(userId);
        when(user.getUsername()).thenReturn(name);
        userService.getUserInforById(userId);

    }

    /**
     * 用例：用户添加用户设备
     */
    public void test_add_device(){
        Device device = new Device();
        device.setUserId(1L);
        device.setName("设备名称");
        deviceService.insert(device);
    }

}
