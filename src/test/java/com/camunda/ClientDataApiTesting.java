package com.camunda;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class ClientDataApiTesting
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldReturnUsersNumbers() throws IOException {
        String response = "[{\"id\":1,\"email\":\"george.bluth@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Bluth\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg\"},{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\",\"last_name\":\"Weaver\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg\"}]" ;
        int userCount  = UserClient.printsUsersNames(response) ;
       Assert.assertEquals(2 , userCount );
    }

    @Test
    public void shouldReturnTureForFirstUserName() throws IOException {
        String response = "[{\"id\":1,\"email\":\"george.bluth@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Bluth\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg\"},{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\",\"last_name\":\"Weaver\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg\"}]" ;
        boolean foundUserName  = UserClient.check_first_user_name(response) ;
        Assert.assertTrue(foundUserName);
    }
}
