class Solution {

    public String encode(List<String> strs) {
        //take the list of string and get the string length and append # and append string. "length#string"
        StringBuilder enco = new StringBuilder();
        for(String str :  strs){
            enco.append(str.length()).append("#").append(str);
        }
        return enco.toString();
    }


//get the encoded string and then get the each string length and then iterate till the # and then get the substring of encoded string and append proper string in the list 
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j+1;
            j = i+length;
            res.add(str.substring(i,j));
            i=j;
        }
        return res;

    }
}
