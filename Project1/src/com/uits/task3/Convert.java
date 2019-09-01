package com.uits.task3;


public class Convert {
    public static void main() {
        byte arg1 = (byte)45;
        int resultconv1 = ConvertByteToInt(arg1);
        System.out.println("Преобразование Byte=" + arg1 + " to Int = " + resultconv1);

        byte arg2  = (byte)7;
        byte resultconv2 = ConvertByteToByte(arg2);
        System.out.println("Преобразование Byte=" + arg2 + " to Byte = " + resultconv2);

        byte arg3 = (byte)44;
        short resultconv3 = ConvertByteToShort(arg3);
        System.out.println("Преобразование Byte="+arg3+" to Short = " + resultconv3);

        byte arg4 = (byte)44;
        char resultconv4 = ConvertByteToChar(arg4);
        System.out.println("Преобразование Byte="+arg4+" to Char = " + resultconv4);

        byte arg5 = (byte)44;
        long resultconv5 = ConvertByteToLong(arg5);
        System.out.println("Преобразование Byte="+arg5+" to Long = " + resultconv5);

        byte arg6 = (byte)44;
        float resultconv6 = ConvertByteToFloat(arg6);
        System.out.println("Преобразование Byte="+arg6+" to Float = " + resultconv6);

        byte arg7 = (byte)44;
        double resultconv7 = ConvertByteToDouble(arg7);
        System.out.println("Преобразование Byte="+arg7+" to Double = " + resultconv7);

        short arg8 = (short) 44;
        byte resultconv8 = ConvertShortToByte(arg8);
        System.out.println("Преобразование Short="+arg8+" to Byte = " + resultconv8);

        short arg9 = (short) 44;
        short resultconv9 = ConvertShortToShort(arg9);
        System.out.println("Преобразование Short="+arg9+" to Short = " + resultconv9);

        short arg10 = (short)44;
        long resultconv10 = ConvertShortToLong(arg10);
        System.out.println("Преобразование Short="+arg10+" to Long = " + resultconv10);

        short arg11 = (short)44;
        char resultconv11 = ConvertShortToChar(arg11);

        short arg12 = (short)44;
        float resultconv12 = ConvertShortToFloat(arg12);
        System.out.println("Преобразование Short="+arg12+" to Float = " + resultconv12);

        short arg13 = (short)44;
        double resultconv13 = ConvertShortToDouble(arg13);
        System.out.println("Преобразование Short="+arg13+" to Double = " + resultconv13);

        short arg14 = (short)44;
        float resultconv14 = ConvertShortToFloat(arg14);
        System.out.println("Преобразование Short="+arg14+" to Float = " + resultconv14);

        short arg15 = (short)44;
        int resultconv15 = ConvertShortToInt(arg15);
        System.out.println("Преобразование Short="+arg15+" to Int = " + resultconv15);

        char arg16 = (char)44;
        byte resultconv16 = ConvertCharToByte(arg16);
        System.out.println("Преобразование Char ="+arg16+" to Byte = " + resultconv16);

        char arg17 = (char)44;
        long resultconv17 = ConvertCharToLong(arg17);
        System.out.println("Преобразование Char="+arg17+" to Long = " + resultconv17);

        char arg18 = (char)44;
        short resultconv18 = ConvertCharToShort(arg18);
        System.out.println("Преобразование Char="+arg18+" to Short = " + resultconv18);

        char arg19 = (char)44;
        int resultconv19 = ConvertCharToInt(arg19);
        System.out.println("Преобразование Char="+arg19+" to Int = " + resultconv19);

        char arg20 = (char)44;
        float resultconv20 = ConvertCharToFloat(arg20);
        System.out.println("Преобразование Char="+arg20+" to Float = " + resultconv20);

        char arg21 = (char)44;
        double resultconv21= ConvertCharToDouble(arg21);
        System.out.println("Преобразование Char="+arg21+" to Double = " + resultconv21);

        int arg22 = (int)44;
        byte resultconv22 = ConvertIntToByte(arg22);
        System.out.println("Преобразование Int="+arg22+" to Byte = " + resultconv22);

        int arg23 = (int)44;
        short resultconv23 = ConvertIntToShort(arg23);
        System.out.println("Преобразование Int="+arg23+" to Short = " + resultconv23);

        int arg24 = (int)44;
        int resultconv24 = ConvertIntToInt(arg24);
        System.out.println("Преобразование Int="+arg24+" to Int = " + resultconv24);

        int arg25 = (int)44;
        char resultconv25 = ConvertIntToChar(arg25);
        System.out.println("Преобразование Int="+arg25+" to Char= " + resultconv25);

        int arg26 = (int)44;
        long resultconv26 = ConvertIntToLong(arg26);
        System.out.println("Преобразование Int="+arg26+" to Long = " + resultconv26);

        int arg27 = (int)44;
        float resultconv27 = ConvertIntToFloat(arg27);
        System.out.println("Преобразование Int="+arg27+" to Float = " + resultconv27);

        int arg28 = (int)44;
        double resultconv28 = ConvertIntToDouble(arg28);
        System.out.println("Преобразование Int="+arg28+" to Double = " + resultconv28);

        long arg29 = (long)44;
        byte resultconv29 = ConvertLongToByte(arg29);
        System.out.println("Преобразование Long="+arg29+" to Byte = " + resultconv29);

        long arg30 = (long)44;
        short resultconv30 = ConvertLongToShort(arg30);
        System.out.println("Преобразование Long="+arg30+" to Short = " + resultconv30);

        long arg31 = (long)44;
        char resultconv31 = ConvertLongToChar(arg31);
        System.out.println("Преобразование Long="+arg31+" to Char= " + resultconv31);

        long arg32 = (long)44;
        int resultconv32 = ConvertLongToInt(arg32);
        System.out.println("Преобразование Long="+arg32+" to Int= " + resultconv32);

        long arg33 = (long)44;
        float resultconv33 = ConvertLongToFloat(arg33);
        System.out.println("Преобразование Long="+arg33+" to Float = " + resultconv33);

        long arg34 = (long)44;
        long resultconv34 = ConvertLongToLong(arg34);
        System.out.println("Преобразование Long="+arg34+" to Long = " + resultconv34);




        ConvertLongToLong((long)8);
        //ConvertLongToByte((long)8);
        //ConvertLongToShort((long)8);
       // ConvertLongToChar((long)8);
       // ConvertLongToInt((long)8);
        ConvertLongToFloat((long)8);
        ConvertLongToDouble((long)8);

        ConvertFloatToByte((float)8);
        ConvertFloatToShort((float)8);
        ConvertFloatToChar((float)8);
        ConvertFloatToInt((float)8);
        ConvertFloatToLong((float)8);
        ConvertFloatToFloat((float)8);
        ConvertFloatToDouble((float)8);

        ConvertDoubleToByte((double)8);
        ConvertDoubleToShort((double)8);
        ConvertDoubleToChar((double)8);
        ConvertDoubleToInt((double)8);
        ConvertDoubleToLong((double)8);
        ConvertDoubleToFloat((double)8);
        ConvertDoubleToDouble((double)8);

        ConvertBooleanToBoolean((boolean) true);
    }



    static int ConvertByteToInt(byte b) {
        int a = b;
        return a;
        //неявное преобразование
    }

    static byte ConvertByteToByte(byte b) {
        byte a = (byte) b;
        return a;
    }
    static short ConvertByteToShort(byte b) {
        short a = b;
        return a;
    }
    static char ConvertByteToChar(byte b) {
        char a = (char) b;
        return a;
//неявное преобразование
    }
    static long ConvertByteToLong(byte b) {
        long a = b;
        return a;
    }
 static float ConvertByteToFloat(byte b) {
     float a = b;
     return a;
 }
    static double ConvertByteToDouble(byte b) {
        double a = b;
        return a;
    }
  /* static boolean ConvertByteToBoolean(byte b) {
        boolean a = (boolean)b;
        return a;
        // преобразование невозможно
    }*/

    static byte ConvertShortToByte(short b) {
        byte a = (byte)b;
        return a;
    }
    static short ConvertShortToShort(short b) {
        short a = b;
        return a;
    }
    static char  ConvertShortToChar(short b) {
        char a = (char)b;
        return a;
    }
    static int  ConvertShortToInt(short b) {
        int a = b;
        return a;
    }
    static long ConvertShortToLong(short b) {
        long a = b;
        return a;
    }
    static float ConvertShortToFloat(short b) {
        float a = b;
        return a;
    }
    static double  ConvertShortToDouble(short b) {
        double a = b;
        return a;
    }
   /* static boolean  ConvertShortToBoolean(short b) {
        boolean a = boolean b;
        return a;
    }  преобразование невозможно */

   static byte  ConvertCharToByte(char b) {
       byte a =(byte) b;
       return a;
   }
    static short  ConvertCharToShort(char b) {
        short a = (short)b;
        return a;
    }
    static char  ConvertCharToChar(char b) {
        char a = b;
        return a;
    }
    static int  ConvertCharToInt(char b) {
        int a = b;
        return a;
    }
    static long ConvertCharToLong(char b) {
        long a = b;
        return a;
    }

    static float ConvertCharToFloat(char b) {
        float a = b;
        return a;
    }
    static double ConvertCharToDouble(char b) {
        double a = b;
        return a;
    }
   /* static boolean ConvertCharToBoolean(char b) {
        boolean a = (boolean) b;
        return a;
    }преобразование невозможно*/

    static byte ConvertIntToByte(int b) {
        byte a = (byte) b;
        return a;
        //явное преобразование
    }
    static short ConvertIntToShort(int b) {
        short a = (short) b;
        return a;
        //явное преобразование
    }
    static char ConvertIntToChar(int b) {
        char a = (char)b;
        return a;
        //явное преобразование
    }
    static long ConvertIntToLong(int b) {
        long a = b;
        return a;
        //не явное преобразование
    }
    static int ConvertIntToInt(int b) {
        int a = b;
        return a;
    }
    static float ConvertIntToFloat(int b) {
        float a =  b;
        return a;
    }
    static double ConvertIntToDouble(int b) {
        double a = b;
        return a;
        // не явное преобразование
    }
   /* static boolean ConvertIntToBoolean(int b) {
        boolean a = (boolean) b;
        return a;
        преобразование невозможно
    }*/

    static byte ConvertLongToByte(long b) {
        byte a = (byte) b;
        return a;
        //явное преобразование
    }
    static short ConvertLongToShort(long b) {
        short a = (short)b;
        return a;
        //явное преобразование
    }
    static char ConvertLongToChar(long b) {
        char a = (char) b;
        return a;
        //явное преобразование
    }
    static int ConvertLongToInt(long b) {
        int a = (int) b;
        return a;
    }
    static long ConvertLongToLong(long b) {
        long a = b;
        return a;
    }
    static float ConvertLongToFloat(long b) {
        float a = b;
        return a;
    }
    static double ConvertLongToDouble(long b) {
        double a = b;
        return a;
    }
   /* static boolean ConvertLongToBoolean(long b) {
        boolean a = (boolean) b;
        return a;
    }*/
   static byte ConvertFloatToByte(float b) {
       byte a = (byte) b;
       return a;
   }
    static short ConvertFloatToShort(float b) {
        short a = (short) b;
        return a;
    }
    static char ConvertFloatToChar(float b) {
        char a = (char) b;
        return a;
    }
    static int ConvertFloatToInt(float b) {
        int a = (int) b;
        return a;
    }
    static long ConvertFloatToLong(float b) {
        long a = (long) b;
        return a;
    }
    static float ConvertFloatToFloat(float b) {
        float a = b;
        return a;
    }
    static double ConvertFloatToDouble(float b) {
        double a = b;
        return a;
    }
   /* static boolean ConvertFloatToBoolean(float b) {
        boolean a = (boolean) b;
        return a;
    }*/
   static byte ConvertDoubleToByte(double b) {
       byte a = (byte)b;
       return a;
   }
    static short ConvertDoubleToShort(double b) {
        short a = (short)b;
        return a;
    }
    static char ConvertDoubleToChar(double b) {
        char a = (char)b;
        return a;
    }
    static int ConvertDoubleToInt(double b) {
        int a = (int)b;
        return a;
    }
    static long ConvertDoubleToLong(double b) {
        long a =(long) b;
        return a;
    }
    static float ConvertDoubleToFloat(double b) {
        float a = (float)b;
        return a;
    }
    static double ConvertDoubleToDouble(double b) {
        double a = b;
        return a;
    }
   /* static boolean ConvertDoubleToBoolean(double b) {
        boolean a =( boolean)b;
        return a;
    }*/

   /* static byte ConvertBooleanToByte(boolean b) {
        byte a = (byte) b;
        return a;
    } преобразование  невозможно
    */

   /* static short ConvertBooleanToShort(boolean b) {
        short a = (short) b;
        return a;
    }*/
   /*static char ConvertBooleanToChar(boolean b) {
       char a = (char) b;
       return a;

  /* static int ConvertBooleanToInt(boolean b) {
       int a = (int) b;
       return a;

   static float ConvertBooleanToFloat(boolean b) {
       float a = (float) b;
       return a;
   }
    static double ConvertBooleanToDouble(boolean b) {
        double a = (double) b;
        return a;
    }*/
   static boolean ConvertBooleanToBoolean(boolean b) {
       boolean a =  b;
       return a;
   }
}
