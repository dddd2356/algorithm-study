class Solution {
    public String solution(String s, int n) {
        
        StringBuilder sb = new StringBuilder();
        
        char[] c;
        c= s.toCharArray();

        for(int i=0; i<c.length; i++){
            if(c[i]>='a' && c[i]<='z'){
                if(c[i] + n > 'z') {
                    c[i] = (char) (c[i] + n - 26);
                    sb.append(c[i]);
                }
                else {
                    c[i] = (char) (c[i] + n);
                    sb.append(c[i]);
                }
            }
            else if(c[i]>='A' && c[i]<='Z'){
                if(c[i] + n > 'Z') {
                    c[i] = (char) (c[i] + n - 26);
                    sb.append(c[i]);
                }
                else {
                    c[i] = (char) (c[i] + n);
                    sb.append(c[i]);
                }
            }
            else if(c[i]==' '){
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}