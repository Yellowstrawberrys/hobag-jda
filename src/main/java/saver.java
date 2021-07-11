public class saver {

    //호빵 일해
    public boolean buyjk(String username){
        try{
            String s = new load().zeone(username);
            String s1 = new load().zeonh(username);
            String s2 = new load().jk(username);
            String s3 = new load().jk_cm(username);
            String s4 = new load().da(username);
            String s5 = new load().iep(username);
            int ss = Integer.parseInt(s2);
            int m = Integer.parseInt(new load().money(username));
            if (main.stk.jk <= m){
                m -= main.stk.jk;
                ss++;
                s2 = String.valueOf(ss);
                new save(username,s,s2,s1,String.valueOf(m),s3, s4, s5);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println("Creating New Bank Account...");
            new save(username, "0", "0", "0", "100","0", "0", "0");
            try{
                String s = new load().zeone(username);
                String s1 = new load().zeonh(username);
                String s2 = new load().jk(username);
                String s3 = new load().jk_cm(username);
                String s4 = new load().da(username);
                String s5 = new load().iep(username);
                int ss = Integer.parseInt(s2);
                int m = Integer.parseInt(new load().money(username));
                if (main.stk.jk <= m){
                    m -= main.stk.jk;
                    ss++;
                    s2 = String.valueOf(ss);
                    new save(username,s,s2,s1,String.valueOf(m),s3, s4, s5);
                    return true;
                }else{
                    return false;
                }
            }catch (Exception e1){
                System.out.println("ERROR");
                return false;
            }
        }
    }

    //제온 일렉트로닉
    public boolean buyzeone(String username){
        try{
            String s = new load().jk(username);
            String s1 = new load().zeonh(username);
            String s2 = new load().zeone(username);
            String s3 = new load().jk_cm(username);
            String s4 = new load().da(username);
            String s5 = new load().iep(username);
            int ss = Integer.parseInt(s2);
            int m = Integer.parseInt(new load().money(username));
            if (main.stk.zeone <= m){
                m -= main.stk.zeone;
                ss++;
                s2 = String.valueOf(ss);
                new save(username,s2,s,s1,String.valueOf(m),s3, s4, s5);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println("Creating New Bank Account...");
            new save(username, "0", "0", "0", "100","0", "0", "0");
            try{
                String s = new load().jk(username);
                String s1 = new load().zeonh(username);
                String s2 = new load().zeone(username);
                String s3 = new load().jk_cm(username);
                String s4 = new load().da(username);
                String s5 = new load().iep(username);
                int ss = Integer.parseInt(s2);
                int m = Integer.parseInt(new load().money(username));
                if (main.stk.zeone <= m){
                    m -= main.stk.zeone;
                    ss++;
                    s2 = String.valueOf(ss);
                    new save(username,s2,s,s1,String.valueOf(m),s3, s4, s5);
                    return true;
                }else{
                    return false;
                }
            }catch (Exception e1){
                System.out.println("ERROR");
                return false;
            }
        }
    }

    //제온핼트
    public boolean buyzeonh(String username){
        try{
            String s = new load().zeone(username);
            String s1 = new load().jk(username);
            String s2 = new load().zeonh(username);
            String s3 = new load().jk_cm(username);
            String s4 = new load().da(username);
            String s5 = new load().iep(username);
            int ss = Integer.parseInt(s2);
            int m = Integer.parseInt(new load().money(username));
            if (main.stk.zeonh <= m){
                m -= main.stk.zeonh;
                ss++;
                s2 = String.valueOf(ss);
                new save(username,s,s1,s2,String.valueOf(m),s3,s4,s5);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println("Creating New Bank Account...");
            new save(username, "0", "0", "0", "100","0", "0", "0");
            try{
                String s = new load().zeone(username);
                String s1 = new load().jk(username);
                String s2 = new load().zeonh(username);
                String s3 = new load().jk_cm(username);
                String s4 = new load().da(username);
                String s5 = new load().iep(username);
                int ss = Integer.parseInt(s2);
                int m = Integer.parseInt(new load().money(username));
                if (main.stk.zeonh <= m){
                    m -= main.stk.zeonh;
                    ss++;
                    s2 = String.valueOf(ss);
                    new save(username,s,s1,s2,String.valueOf(m),s3,s4,s5);
                    return true;
                }else{
                    return false;
                }
            }catch (Exception e1){
                System.out.println("ERROR");
                return false;
            }
        }
    }
    /*
    * 여기부터는 판매입니다
    *
    *
    *
    *
    *
    *
    *
    * */

    //호빵 일해
    public boolean selljk(String username){
        try{
            String s = new load().zeone(username);
            String s1 = new load().zeonh(username);
            String s2 = new load().jk(username);
            String s3 = new load().jk_cm(username);
            String s4 = new load().da(username);
            String s5 = new load().iep(username);
            int ss = Integer.parseInt(s2);
            int m = Integer.parseInt(new load().money(username));
            m += main.stk.jk;
            ss--;
            s2 = String.valueOf(ss);
            new save(username,s,s2,s1,String.valueOf(m),s3,s4,s5);
            return true;
        }catch (Exception e){
            System.out.println("Creating New Bank Account...");
            new save(username, "0", "0", "0", "100","0", "0", "0");
            try{
                String s = new load().zeone(username);
                String s1 = new load().zeonh(username);
                String s2 = new load().jk(username);
                String s3 = new load().jk_cm(username);
                String s4 = new load().da(username);
                String s5 = new load().iep(username);
                int ss = Integer.parseInt(s2);
                int m = Integer.parseInt(new load().money(username));
                m += main.stk.jk;
                ss--;
                s2 = String.valueOf(ss);
                new save(username,s,s2,s1,String.valueOf(m),s3,s4,s5);
                return true;
            }catch (Exception e1){
                System.out.println("ERROR");
                return false;
            }
        }
    }

    //제온 일렉트로닉
    public boolean sellzeone(String username){
        try{
            String s = new load().zeone(username);
            String s1 = new load().zeonh(username);
            String s2 = new load().jk(username);
            String s3 = new load().jk_cm(username);
            String s4 = new load().da(username);
            String s5 = new load().iep(username);
            int ss = Integer.parseInt(s2);
            int m = Integer.parseInt(new load().money(username));
                m += main.stk.jk;
                ss--;
                s2 = String.valueOf(ss);
                new save(username,s,s2,s1,String.valueOf(m),s3,s4,s5);
            return true;
        }catch (Exception e){
            System.out.println("Creating New Bank Account...");
            new save(username, "0", "0", "0", "100","0", "0", "0");
            try{
                String s = new load().zeone(username);
                String s1 = new load().zeonh(username);
                String s2 = new load().jk(username);
                String s3 = new load().jk_cm(username);
                String s4 = new load().da(username);
                String s5 = new load().iep(username);
                int ss = Integer.parseInt(s2);
                int m = Integer.parseInt(new load().money(username));
                m += main.stk.jk;
                ss--;
                s2 = String.valueOf(ss);
                new save(username,s,s2,s1,String.valueOf(m),s3,s4,s5);
                return true;
            }catch (Exception e1){
                System.out.println("ERROR");
                return false;
            }
        }
    }

    //제온핼트
    public boolean sellzeonh(String username){
        try{
            String s = new load().zeone(username);
            String s1 = new load().jk(username);
            String s2 = new load().zeonh(username);
            String s3 = new load().jk_cm(username);
            String s4 = new load().da(username);
            String s5 = new load().iep(username);
            int ss = Integer.parseInt(s2);
            int m = Integer.parseInt(new load().money(username));
                m += main.stk.jk;
                ss--;
                s2 = String.valueOf(ss);
                new save(username,s,s2,s1,String.valueOf(m),s3,s4,s5);
            return true;
        }catch (Exception e){
            System.out.println("Creating New Bank Account...");
            new save(username, "0", "0", "0", "100","0", "0", "0");
            try{
                String s = new load().zeone(username);
                String s1 = new load().jk(username);
                String s2 = new load().zeonh(username);
                String s3 = new load().jk_cm(username);
                String s4 = new load().da(username);
                String s5 = new load().iep(username);
                int ss = Integer.parseInt(s2);
                int m = Integer.parseInt(new load().money(username));
                m += main.stk.jk;
                ss--;
                s2 = String.valueOf(ss);
                new save(username,s,s2,s1,String.valueOf(m),s3,s4,s5);
                return true;
            }catch (Exception e1){
                System.out.println("ERROR");
                return false;
            }
        }
    }
    //JK CM 일해
    public boolean buyjkcm(String username){
        try{
            String s = new load().zeone(username);
            String s1 = new load().zeonh(username);
            String s3 = new load().jk(username);
            String s2 = new load().jk_cm(username);
            String s4 = new load().da(username);
            String s5 = new load().iep(username);
            int ss = Integer.parseInt(s2);
            int m = Integer.parseInt(new load().money(username));
            if (main.stk.jk_cm <= m){
                m -= main.stk.jk_cm;
                ss++;
                s2 = String.valueOf(ss);
                new save(username,s,s3,s1,String.valueOf(m),s2,s4,s5);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println("Creating New Bank Account...");
            new save(username, "0", "0", "0", "100","0", "0", "0");
            try{
                String s = new load().zeone(username);
                String s1 = new load().zeonh(username);
                String s3 = new load().jk(username);
                String s2 = new load().jk_cm(username);
                String s4 = new load().da(username);
                String s5 = new load().iep(username);
                int ss = Integer.parseInt(s2);
                int m = Integer.parseInt(new load().money(username));
                if (main.stk.jk_cm <= m){
                    m -= main.stk.jk_cm;
                    ss++;
                    s2 = String.valueOf(ss);
                    new save(username,s,s3,s1,String.valueOf(m),s2,s4,s5);
                    return true;
                }else{
                    return false;
                }
            }catch (Exception e1){
                System.out.println("ERROR");
                return false;
            }
        }
    }

    //돈 넣기
    public boolean give(String username, int much) {
        try {
            String s = new load().jk(username);
            String s1 = new load().zeonh(username);
            String s2 = new load().zeone(username);
            String s3 = new load().jk_cm(username);
            String s4 = new load().da(username);
            String s5 = new load().iep(username);
            int m = Integer.parseInt(new load().money(username)) + much;
            new save(username, s2, s, s1, String.valueOf(m), s3,s4,s5);
            return true;
        } catch (Exception e) {
            System.out.println("Creating New Bank Account...");
            new save(username, "0", "0", "0", "100","0", "0", "0");
            try {
                String s = new load().jk(username);
                String s1 = new load().zeonh(username);
                String s2 = new load().zeone(username);
                String s3 = new load().jk_cm(username);
                String s4 = new load().da(username);
                String s5 = new load().iep(username);
                int m = Integer.parseInt(new load().money(username)) + much;
                new save(username, s2, s, s1, String.valueOf(m), s3,s4,s5);
                return true;
            } catch (Exception e1) {
                System.out.println("ERROR");
                return false;
            }
        }

    }
    //돈 빼기
    public boolean go(String username, int much) {
        try {
            String s = new load().jk(username);
            String s1 = new load().zeonh(username);
            String s2 = new load().zeone(username);
            String s3 = new load().jk_cm(username);
            String s4 = new load().da(username);
            String s5 = new load().iep(username);
            int m = Integer.parseInt(new load().money(username)) - much;
            new save(username, s2, s, s1, String.valueOf(m), s3,s4,s5);
            return true;
        } catch (Exception e) {
            System.out.println("Creating New Bank Account...");
            new save(username, "0", "0", "0", "100","0", "0", "0");
            try {
                String s = new load().jk(username);
                String s1 = new load().zeonh(username);
                String s2 = new load().zeone(username);
                String s3 = new load().jk_cm(username);
                String s4 = new load().da(username);
                String s5 = new load().iep(username);
                int m = Integer.parseInt(new load().money(username)) - much;
                new save(username, s2, s, s1, String.valueOf(m), s3,s4,s5);
                return true;
            } catch (Exception e1) {
                System.out.println("ERROR");
                return false;
            }
        }

    }
    //대출 하기
    public boolean da_do(String username, int much) {
        try {
            String s = new load().jk(username);
            String s1 = new load().zeonh(username);
            String s2 = new load().zeone(username);
            String s3 = new load().jk_cm(username);
            String s4 = new load().da(username);
            String s5 = new load().iep(username);
            String m = new load().money(username);
            if(much+Integer.parseInt(s4) >= 500){
                return false;
            }else {
                int mm = Integer.parseInt(m) + much;
                int ms = Integer.parseInt(s4)+much;
                new save(username, s2, s, s1, String.valueOf(mm), s3, String.valueOf(ms), s5);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Creating New Bank Account...");
            new save(username, "0", "0", "0", "100","0", "0", "0");
            try {
                String s = new load().jk(username);
                String s1 = new load().zeonh(username);
                String s2 = new load().zeone(username);
                String s3 = new load().jk_cm(username);
                String s4 = new load().da(username);
                String s5 = new load().iep(username);
                if(much+Integer.parseInt(s4) >= 500){
                    return false;
                }else {
                    int m = Integer.parseInt(new load().money(username)) + much;
                    int ms = Integer.parseInt(s4)+much;
                    new save(username, s2, s, s1, String.valueOf(m), s3, String.valueOf(ms), s5);
                    return true;
                }
            } catch (Exception e1) {
                System.out.println("ERROR");
                return false;
            }
        }

    }
    //갚기
    public boolean da_back(String username, int much) {
        try {
            String s = new load().jk(username);
            String s1 = new load().zeonh(username);
            String s2 = new load().zeone(username);
            String s3 = new load().jk_cm(username);
            String s4 = new load().da(username);
            String s5 = new load().iep(username);
            int m = Integer.parseInt(new load().money(username))-much;
            if(m>=0){
                if(Integer.getInteger(s4)-much <= 0){
                    int mm = 500-Integer.getInteger(s4);
                    new save(username, s2, s, s1, String.valueOf(mm+m), s3, "0", s5);
                }else{
                    int mm = Integer.getInteger(s4)-much;
                    new save(username, s2, s, s1, String.valueOf(m), s3, String.valueOf(mm), s5);
                }
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            System.out.println("Creating New Bank Account...");
            new save(username, "0", "0", "0", "100","0", "0", "0");
            return true;
        }
    }
    //송금
    public boolean sogum(String username, int much, String to) {
        try {
            String s = new load().jk(username);
            String s1 = new load().zeonh(username);
            String s2 = new load().zeone(username);
            String s3 = new load().jk_cm(username);
            String s4 = new load().da(username);
            String s5 = new load().iep(username);
            int m = Integer.parseInt(new load().money(username));
            if(m>=much || m==much){

                new save(username, s2, s, s1, String.valueOf(m-much), s3, s4, s5);
                new save(to, new load().zeone(to), new load().jk(to), new load().zeonh(to), String.valueOf(Integer.parseInt(new load().money(to))+much), new load().jk_cm(to), new load().da(to), new load().iep(to));
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            try {
                String s = new load().jk(username);
                String s1 = new load().zeonh(username);
                String s2 = new load().zeone(username);
                String s3 = new load().jk_cm(username);
                String s4 = new load().da(username);
                String s5 = new load().iep(username);
                int m = Integer.parseInt(new load().money(username));
                if(m>=much || m==much){
                    new save(username, s2, s, s1, String.valueOf(m-much), s3, s4, s5);
                    new save(to, new load().zeone(to), new load().jk(to), new load().zeonh(to), String.valueOf(Integer.parseInt(new load().money(to))+much), new load().jk_cm(to), new load().da(to), new load().iep(to));
                    return true;
                }else{
                    return false;
                }
            } catch (Exception e1) {
                System.out.println("ERROR");
                return true;
            }
        }
    }


    //통장에 넣기
    public boolean put(String username, int much) {
        try {
            String s = new load().jk(username);
            String s1 = new load().zeonh(username);
            String s2 = new load().zeone(username);
            String s3 = new load().jk_cm(username);
            String s4 = new load().da(username);
            String s5 = new load().iep(username);
            int m = Integer.parseInt(new load().money(username));
                if(m-much <= 0){
                    return false;
                }else {
                    int mm = m - much;
                    int mmm = Integer.parseInt(s5) + much;
                    new save(username, s2, s, s1, String.valueOf(mm), s3, s4, String.valueOf(mmm));
                    return true;
                }

        } catch (Exception e) {
            System.out.println("Creating New Bank Account...");
            new save(username, "0", "0", "0", "100","0", "0", "0");
            try {
                String s = new load().jk(username);
                String s1 = new load().zeonh(username);
                String s2 = new load().zeone(username);
                String s3 = new load().jk_cm(username);
                String s4 = new load().da(username);
                String s5 = new load().iep(username);
                int m = Integer.parseInt(new load().money(username));
                if(m-much <= 0){
                    return false;
                }else {
                    int mm = m - much;
                    int mmm = Integer.parseInt(s5) + much;
                    new save(username, s2, s, s1, String.valueOf(mm), s3, s4, String.valueOf(mmm));
                    return true;
                }

            } catch (Exception e1) {
                System.out.println("ERROR");
                return false;
            }
        }
    }
    //통장에서 빼기
    public boolean out(String username, int much) {
        try {
            String s = new load().jk(username);
            String s1 = new load().zeonh(username);
            String s2 = new load().zeone(username);
            String s3 = new load().jk_cm(username);
            String s4 = new load().da(username);
            String s5 = new load().iep(username);
            int m = Integer.parseInt(new load().money(username));
            if(Integer.parseInt(s5)-much <= 0){
                return false;
            }else {
                int mm = m + much;
                int mmm = Integer.parseInt(s5) - much;
                new save(username, s2, s, s1, String.valueOf(mm), s3, s4, String.valueOf(mmm));
                return true;
            }

        } catch (Exception e) {
            System.out.println("Creating New Bank Account...");
            new save(username, "0", "0", "0", "100","0", "0", "0");
            try {
                String s = new load().jk(username);
                String s1 = new load().zeonh(username);
                String s2 = new load().zeone(username);
                String s3 = new load().jk_cm(username);
                String s4 = new load().da(username);
                String s5 = new load().iep(username);
                int m = Integer.parseInt(new load().money(username));
                if(Integer.parseInt(s5)-much <= 0){
                    return false;
                }else {
                    int mm = m + much;
                    int mmm = Integer.parseInt(s5) - much;
                    new save(username, s2, s, s1, String.valueOf(mm), s3, s4, String.valueOf(mmm));
                    return true;
                }

            } catch (Exception e1) {
                System.out.println("ERROR");
                return false;
            }
        }
    }

}
