package com.music.waitnotify;

public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Client1", 3141592L).start();
        new ServerThread(requestQueue, "Server1", 6535897L).start();
    }
}
