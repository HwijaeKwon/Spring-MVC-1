package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");

        HelloData helloData = new HelloData();
        helloData.setUsername("kwon");
        helloData.setAge(20);

        //{"username":"kim", "age":20}
        String result = objectMapper.writeValueAsString(helloData);
        // writer를 사용했을 때 encoding type이 자동으로 추가된다 -> application/json은 utf-8을 자동으로 사용하므로 추가할 필요가 없다
        // writer 대신 OutputStream을 사용하면 encoding type이 자동으로 추가되지 않는다
        response.getOutputStream().print(result);
    }
}
