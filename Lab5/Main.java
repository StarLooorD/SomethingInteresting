package Lab5;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static Vacancy vacFind(int id,ListContainer<Vacancy> vac){
        Iterator<Vacancy> myItr = vac.iterator();
        while(myItr.hasNext()){
            Vacancy t = myItr.next();
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        boolean autoMode = false;
        for(int i = 0;i < args.length;i++){
            if(args[i].equals("-auto")){
                autoMode = true;
            }
        }
        ListContainer<Vacancy> vacancyList = new ListContainer<>();
        Scanner scan = new Scanner(System.in);
        if(autoMode){
            try {
                scan = new Scanner(new BufferedInputStream(new FileInputStream("automode.txt")));
            }catch(FileNotFoundException ex){
                System.err.println("������������ ����� �� ��������!");
                scan = new Scanner(System.in);
            }
        }
        int command,id;
        String str;
        while(true){
            if(autoMode){
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch(InterruptedException e){

                }
            }
            System.out.println("1 - ������ �������");
            System.out.println("2 - �������� �������");
            System.out.println("3 - ����������� ������ �������");
            System.out.println("4 - ���� ������");
            System.out.println("5 - �������� ������ � XML-����");
            System.out.println("6 - ������� ������ � XML-�����");
            System.out.println("7 - �����");
            command = scan.nextInt();
            switch(command){
                case 1:
                    System.out.println("������ ����� �����:");
                    scan.nextLine();
                    Vacancy vac = new Vacancy();
                    str = scan.nextLine();
                    if(str.matches("\\w+")){
                        vac.setFirm(str);
                        vacancyList.add(vac);
                        System.out.println("������� '"+vac.getFirm()+"' ������ � ���������������: "+vac.getId());
                    }
                    else{
                        System.err.println("������� �� ������! ��� ����� �������������� ����� ����� � �����!");
                    }
                    break;
                case 2:
                    System.out.println("������ ������������� ������, ��� ��������:");
                    id = scan.nextInt();
                    if(!vacancyList.remove(id)){
                        System.err.println("������ �������� �� ��������!");
                    }
                    else{
                        System.out.println("������� ��������!");
                    }
                    break;
                case 3:
                    Iterator<Vacancy> myItr1 = vacancyList.iterator();
                    while(myItr1.hasNext()){
                        Vacancy t = myItr1.next();
                        System.out.println(t.toString());
                    }
                    break;
                case 4:
                    System.out.println("������ ID ������, ��� �� ����������: ");
                    id = scan.nextInt();
                    Vacancy temp = vacFind(id,vacancyList);
                    if(temp != null){
                        System.out.println("������� ��������!");
                        boolean exit = false;
                        while(!exit) {
                            System.out.println(temp.toString());
                            System.out.println("1 - ������ �����");
                            System.out.println("2 - ������ ������������");
                            System.out.println("3 - ������ ����� �����");
                            System.out.println("4 - ������ ������");
                            System.out.println("5 - ������ ������");
                            System.out.println("6 - ����������� �� ���. ����");
                            command  = scan.nextInt();
                            switch(command){
                                case 1:
                                    System.out.println("������ ���� �����:");
                                    scan.nextLine();
                                    str = scan.nextLine();
                                    if(str.matches("\\w+")){
                                        temp.setFirm(str);
                                        System.out.println("������ ������!");
                                        break;
                                    }
                                    System.err.println("�� ������! ������ ����� � ���� � ����!");
                                    break;
                                case 2:
                                    System.out.println("������ ���� ������������:");
                                    scan.nextLine();
                                    str = scan.nextLine();
                                    if(str.matches("\\w+")){
                                        temp.setSpeciality(str);
                                        System.out.println("������ ������!");
                                        break;
                                    }
                                    System.err.println("�� ������! ������ ����� � ���� � ����!");
                                    break;
                                case 3:
                                    System.out.println("������ ��� ����� �����:");
                                    scan.nextLine();
                                    str = scan.nextLine();
                                    if(str.matches("\\w+")){
                                        temp.setConditions(str);
                                        System.out.println("������ ������!");
                                        break;
                                    }
                                    System.err.println("�� ������! ������ ����� � ���� � ����!");
                                    break;
                                case 4:
                                    System.out.println("������ ���� ������(�.�.):");
                                    temp.setSalary(scan.nextInt());
                                    System.out.println("������ ������!");
                                    break;
                                case 5:
                                    System.out.println("��������� ����� �����:");
                                    scan.nextLine();
                                    Preference pref = new Preference();
                                    System.out.println("������������:");
                                    pref.setSpeciality(scan.nextLine());
                                    System.out.println("����:");
                                    pref.setExperience(scan.nextInt());
                                    System.out.println("�����:");
                                    scan.nextLine();
                                    pref.setEducation(scan.nextLine());
                                    temp.addPreference(pref);
                                    System.out.println("������ ������!");
                                    break;
                                case 6:
                                    exit = true;
                                    break;
                            }
                        }
                    }
                    else{
                        System.out.println("������� �� ��������!");
                    }
                    break;
                case 5:
                    FileOutputStream fos;
                    System.out.println("----������ ����� �����:");
                    scan.nextLine();
                    String file_name = scan.nextLine();
                    if(!file_name.matches("\\w+\\.xml")){
                        System.err.println("������ ��'� ����� � ������ XXXXX.xml, �� XXXXX - �����.");
                        break;
                    }
                    System.out.println("----������� ������� ���������, ��� �������� ����:");
                    String path = FileManager.selectDir(scan) + "\\" + file_name;
                    if (!(new File(path)).exists()) {
                        File newFile = new File(path);
                        try
                        {
                            if(newFile.createNewFile())
                                System.out.println("***���� '"+file_name+"' ���� ��������!");
                        }
                        catch(IOException ex){
                            System.out.println(ex.getMessage());
                            break;
                        }
                    }
                    try {
                        fos = new FileOutputStream( path);
                    }catch(FileNotFoundException ex){
                        System.err.println("���� �� ��������!");
                        break;
                    }
                    XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(fos));
                    encoder.writeObject(vacancyList.size());
                    for(Vacancy one : vacancyList){
                        encoder.writeObject(one);
                    }
                    encoder.close();
                    System.out.println("������ ��������!");
                    break;
                case 6:
                    System.out.println("1 - �������� ����� ������(�� ���������� ���������)");
                    System.out.println("2 - ������ �� ��������� ������");
                    command = scan.nextInt();
                    switch(command){
                        case 1:
                            System.out.println("----������� ����:");
                            scan.nextLine();
                            String path_ = FileManager.selectFile(scan);
                            FileInputStream fis;
                            try {
                                fis = new FileInputStream(path_);
                            }catch(FileNotFoundException ex){
                                System.err.println("FileNotFound");
                                break;
                            }
                            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(fis));
                            Integer size = (Integer) decoder.readObject();
                            vacancyList = new ListContainer<>() ;
                            Vacancy.cleanVacancy();
                            for (int i = 0; i < size; i++) {
                                vacancyList.add((Vacancy) decoder.readObject());
                            }
                            decoder.close();

                            break;
                        case 2:
                            System.out.println("----������� ����:");
                            scan.nextLine();
                            String path__ = FileManager.selectFile(scan);
                            FileInputStream fis_;
                            try {
                                fis_ = new FileInputStream(path__);
                            }catch(FileNotFoundException ex){
                                System.err.println("FileNotFound");
                                break;
                            }
                            XMLDecoder decoder_ = new XMLDecoder(new BufferedInputStream(fis_));
                            Integer size_ = (Integer) decoder_.readObject();
                            for (int i = 0; i < size_; i++) {
                                vacancyList.add((Vacancy) decoder_.readObject());
                            }
                            decoder_.close();
                            break;
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;

            }
        }
    }

}