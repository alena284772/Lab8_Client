package Client_side;

import Commands.Command;
import javafx.scene.control.Label;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Sender {
    private SocketAddress socketAddress;
    private static Label answer;

    public void setSocketAddress(SocketAddress socketAddress) {
        this.socketAddress = socketAddress;
    }

    public void setAnswer(Label answer) {
        Sender.answer = answer;
    }

    public SocketAddress getSocketAddress() {
        return socketAddress;
    }

    public Command wait_answer(SocketChannel outcoming) throws IOException {
        Command command00=new Command();
        System.out.println("Answer from server:");
        while(command00.getAnswer()==null) {
            try {
                Thread.sleep(1000);
                command00=this.read_answer(outcoming);
                if(command00.getAnswer()==null){
                    break;
                }else{
                    //System.out.println(command00.getAnswer());
                    if(answer!=null){
                        answer.setText(command00.getAnswer());
                    }
                }
            } catch (IOException e) {
                //System.out.println("Server did not send an answer");
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (NullPointerException e){
                System.out.println("Server is closed");
            }
        }

        return command00;
    }

    public Command sendMessage(Command command) throws IOException {
        SocketChannel outcoming = null;
        boolean canconnect=true;
        try {
            outcoming = SocketChannel.open(socketAddress);
            outcoming.configureBlocking(false);

            System.out.println("Connection established");
            ByteBuffer sendBuffer = ByteBuffer.allocate(16384);
            try (

                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

                objectOutputStream.writeObject(command);

                sendBuffer.put(byteArrayOutputStream.toByteArray());

                objectOutputStream.flush();
                byteArrayOutputStream.flush();
                sendBuffer.flip();
                outcoming.write(sendBuffer);

                System.out.println("----\nMessage sent.\n----");

                objectOutputStream.close();

                byteArrayOutputStream.close();
                sendBuffer.clear();



            } catch (IOException e) {

            }
        } catch (IOException e) {
            System.out.println("В данный момент нет доступа к серверу. Попробуйте сделать запрос позже");
            canconnect=false;
        }
        //wait_answer(outcoming);
        if(canconnect){
            return wait_answer(outcoming);}else{
            Command no=new Command();
            no.setAnswer("Сервер недоступен");
            return no;
        }

    }

    public Command read_answer(SocketChannel socketChannel) throws IOException {
        Command command = new Command();
        ByteBuffer readBuffer = ByteBuffer.allocate(163840);
        try {
            socketChannel.read(readBuffer);
            readBuffer.flip();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readBuffer.array());
            readBuffer.flip();
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Command command1=(Command)objectInputStream.readObject();
            command=command1;
            //System.out.println(command.getAnswer());
            objectInputStream.close();
            byteArrayInputStream.close();
            readBuffer.clear();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Some problem with server. Try again");
            //e.printStackTrace();
        }

        return command;
    }
}
