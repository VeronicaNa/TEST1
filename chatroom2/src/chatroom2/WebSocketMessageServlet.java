package chatroom2;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;

@WebServlet(urlPatterns = { "/message"})
//���Ҫ�����������ws://Э�������ͱ���ʵ��WebSocketServlet�����
public class WebSocketMessageServlet extends org.apache.catalina.websocket.WebSocketServlet {

	private static final long serialVersionUID = 1L;
	
	public static int ONLINE_USER_COUNT	= 1;
	
	public String getUser(HttpServletRequest request){
		return (String) request.getSession().getAttribute("user");
	}

	//��ƽ��Servlet��ͬ���ǣ���Ҫʵ��createWebSocketInbound���������ʼ���Զ����WebSocket���Ӷ���
    @Override
    protected StreamInbound createWebSocketInbound(String subProtocol,HttpServletRequest request) {
        return new WebSocketMessageInbound(this.getUser(request));
    }
}
