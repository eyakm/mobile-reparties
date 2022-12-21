package easy.tuto.myquizapplication;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
public class MyThread implements Runnable {
    private String msg;
    private String msgrecu;


    Socket s;

    @Override
    public void run() {

        try {
            Socket socket = new Socket("192.168.56.1", 4);
            System.out.println("client connected !");
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            pw.println(msg);

            socket.close();
            InputStream sr = socket.getInputStream();
            InputStreamReader r = new InputStreamReader(sr);
            BufferedReader br = new BufferedReader(r);
            String s = br.readLine();

            System.out.println("result=" + s);
            msgrecu = s;

            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }

    }

    public void sendMessage(String msg) {
        this.msg = msg;
        run();
    }

    public String getmsg() {
        return msg;
    }

    public String getmsgrecu() {
        return msgrecu;
    }
}