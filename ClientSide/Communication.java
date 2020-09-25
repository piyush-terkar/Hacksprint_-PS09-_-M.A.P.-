package com.example.mapeat;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Communication extends AsyncTask<String,String,String> {

    @Override
    protected String doInBackground(String... voids) {
    String msg = voids[0];
    Socket socket;
        String recieved = null;
        {
            try {
                socket = new Socket("192.168.1.30", 8000);
                OutputStream out = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(out);
                pw.write(String.valueOf(msg));
                pw.flush();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                recieved = in.readLine();

                out.close();
                pw.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return recieved;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
    }

}