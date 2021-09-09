class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String s) {
    Map<Character,Integer> roman = new HashMap<Character,Integer>();

    roman.put('I', 1);
    roman.put('V', 5);
    roman.put('X', 10);
    roman.put('L', 50);
    roman.put('C', 100);
    roman.put('D', 500);
    roman.put('M', 1000);

    int sum = 0;
    int n = s.length();
     
    for(int i = 0; i < n; i++)
    {
         
        // If present value is less than next value,
        // subtract present from next value and add the
        // resultant to the sum variable.
        if (i != n - 1 && roman.get(s.charAt(i)) <
                          roman.get(s.charAt(i + 1)))
        {
            sum += roman.get(s.charAt(i + 1)) -
                   roman.get(s.charAt(i));
            i++;
        }
        else
        {
            sum += roman.get(s.charAt(i));
        }
    }
    return sum;
    }
}
