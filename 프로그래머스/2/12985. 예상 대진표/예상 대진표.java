class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        for(int i=0; i<n/2; i++){
            if(a%2==0 && b%2==0){
                a = a/2;
                b = b/2;
                answer++;
            }
            else if(a%2==0 && b%2!=0){
                a = a/2;
                b = (b/2)+1;
                answer++;
            }
            else if(a%2!=0 && b%2==0){
                a = (a/2)+1;
                b = b/2;
                answer++;
            }
            else if(a%2!=0 && b%2!=0){
                a = (a/2)+1;
                b = (b/2)+1;
                answer++;
            }
            
            if(a==b){
                break;
            }
        }

        return answer;
    }
}