// class VowelsGameinaString {

//     public boolean Aliceturn(String s){
//         long vowelcount = s.chars().filter(letter->"aAeEiIoOuU".indexOf(letter)!=-1).count();
//         if(vowelcount==0) return false;
//         else if(vowelcount%2!=0) return true;
//         else {
//             int v=0;
//             int i=0;
//             int newindex = 0;
//             while(v<vowelcount){
//                 if("aAeEiIoOuU".indexOf(s.charAt(i)) != -1){
//                     v++;
//                     newindex = i;
//                 }
//                 i++;
//             }

//             s = s.substring(newindex+1,s.length());
//             boolean ret = Bobturn(s);
//             return ret;
//         }
//     }

//     public boolean Bobturn(String s){
//         long vowelcount = s.chars().filter(letter->"aAeEiIoOuU".indexOf(letter)!=-1).count();
//         if(vowelcount==0) return true;
//         else if(vowelcount%2==0) return false;
//         else {
//             int v=0;
//             int i=0;
//             int newindex = 0;
//             while(v<vowelcount){
//                 if("aAeEiIoOuU".indexOf(s.charAt(i)) != -1){
//                     v++;
//                     newindex = i;
//                 }
//                 i++;
//             }

//             s = s.substring(newindex+1,s.length());
//             boolean ret = Aliceturn(s);
//             return ret;
//         }
//     }


//     public boolean doesAliceWin(String s) {
//         boolean doesAlice = Aliceturn(s);
//         return doesAlice;
//     }
// }

class VowelsGameinaString {

    public boolean doesAliceWin(String s) {
        for(char c:s.toCharArray()){
            if("aAeEiIoOuU".indexOf(c)!=-1) return true;
        }
        return false;
    }
}
