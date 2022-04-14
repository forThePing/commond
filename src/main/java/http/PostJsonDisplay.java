package http;

import http.parameter.PostJsonParameter;
import init.Command;
import init.Display;
import org.apache.commons.httpclient.HttpMethod;

/**可以考虑添加对执行结果的解析器*/
public class PostJsonDisplay implements Display  {
    private Command command;

    public PostJsonDisplay(Command command) {
        this.command = command;
    }

    @Override
    public void run(String str) throws Exception {
        PostJsonParameter parameter = new PostJsonParameter();
        parameter.parse(str);
        HttpMethod method = parameter.httpMethod();

        command.run(method);
        parameter.write();
    }

    @Override
    public String desc() {
        return "postJson 执行http post 请求 postJson -u http:// -p {\"name\":\"doctor\"} -w json (目前有文本与json的 )";
    }
}
