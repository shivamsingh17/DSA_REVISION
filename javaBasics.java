            target.add(index[i], nums[i]); 
/ Sort subarray from index 1 to 3 inclusively
        Arrays.sort(a, 1, 4);
        Arrays.sort(a, Collections.reverseOrder());
class Sortbyroll implements Comparator<Student> {
    
    // Used for sorting in ascending order of
    // roll number
    public int compare(Student x, Student y){
      return x.r - y.r;
    }
}
    Arrays.sort(x, new Sortbyroll());
int foo = Integer.parseInt(myString);
