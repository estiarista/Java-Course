package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.print("I am Lalisa");
        System.out.printf("as a QA Engineer");;

        boolean flag;
        for (int i = 1; i<5; i++){
            System.out.println("i = " + i);
        }

        int a = 10;
        int b = 2;
        float c = 3;
        String nama = "Esti";
        char q = 'Y';
        boolean flag2 = false;

        //int result;
        float result; //sebelumnya integer diubah jadi float
        //result = a/b; //10 divide 2 (both int)
        result = (a/c); //10 divide 3 (one of the is float)
        int resultType = (int) (a/c); //Type casting
        System.out.println(result);
        System.out.println(resultType);

        int timeStart = 8;
        int timeFinish = 17;
        int waktuSaya = 6;
        int waktuPulang = 14;
        //Karyawan tepat waktu datang dan pulang dapat selamat
        if (waktuSaya <= timeStart && waktuPulang <= timeFinish) {
            System.out.println("selamat kamu datang tepat waktu");
            System.out.println("Anda datang " + (timeStart - waktuSaya) + " jam lebih cepat");
            System.out.println("Anda pulang " + (waktuPulang - timeFinish) + " jam lebih lama");
            // karyawan datang duluan, pulang cepat, dicengin
        }else if(waktuSaya <= timeStart && waktuPulang <= timeFinish) {
            System.out.println("Datang awal, pulcep nih yee");
            //Karyawan telat, pulang lama, dimaafkan
        } else if (waktuSaya >= timeStart && waktuPulang >= timeFinish) {
            System.out.println("dimaafkan datang telatnya");
        }
        //karyawan telat + pulang cepat disoraki
        else {
            System.out.println("YEUUU TELATT!!");
            System.out.println("Telat " + (waktuSaya - timeStart) + " 1 jam luu!");
            System.out.println("Pulang duluan " + (timeFinish - waktuPulang) + " jam lebih cepat");
        }

        int day = 3;
        switch (day){
            case 1:
                System.out.println("saya WFO");
                break;
            case 2:
                System.out.println("saya libur/cuti");
                break;
            case 3:
                System.out.println("Saya WFH");
                break;
            default:
                System.out.println("Liburan alias weekend");
                break;
        }
        System.out.println("Hehehe");
    }

    //Loop
    //While dan for loop, foreach
}