package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:springMVC.xml"})
public class MyControllerTest {
    @Autowired
    private WebApplicationContext context;

    // debug MockHttpServletRequest#setAttribute Condition name.equals("kk")
    @Test
    public void requestAttrTest() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/requestAttr"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("success"))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertTrue(response.getContentAsString().contains("request Attr"));
    }
    // debug MockHttpServletRequest#setAttribute Condition name.equals("kk")
    @Test
    public void modelValueTest() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/modelValue"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("success"))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertTrue(response.getContentAsString().contains("model Value"));
    }
    // debug MockHttpServletRequest#setAttribute Condition name.equals("kk")
    @Test
    public void modelParamTest() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/modelParam"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("success"))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertTrue(response.getContentAsString().contains("model Param"));
    }
    // debug MockHttpServletRequest#setAttribute Condition name.equals("kk")
    @Test
    public void paramMapTest() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/paramMap"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("success"))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertTrue(response.getContentAsString().contains("param Map"));
    }
    // debug MockHttpServletRequest#setAttribute Condition name.equals("kk")
    @Test
    public void paramModelMapTest() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/paramModelMap"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("success"))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertTrue(response.getContentAsString().contains("param ModelMap"));
    }
    // debug MockHttpSession#getAttribute
    @Test
    public void sessionAttrTest() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/sessionAttr"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("success"))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertTrue(response.getContentAsString().contains("session Attr"));
    }
    // debug MockServletContext#getAttribute Condition "kk".equalsIgnoreCase(name)
    @Test
    public void appAttrTest() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/appAttr"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("success"))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertTrue(response.getContentAsString().contains("app Attr"));
    }
}
