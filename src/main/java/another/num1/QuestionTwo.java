package another.num1;

public class QuestionTwo {

    private boolean result = false;

    private void subSet(int[] array, int target, int index) {
        int subNum = target - array[index];
        if (subNum == 0) {
            result = true;
        }
        for (int i = 0; i < index; i++) {
            if (subNum == array[i]) {
                result = true;
                break;
            }
        }
        if (!result && index - 1 >= 0) {
            // choose index
            subSet(array, subNum , index -1);
            // do not choose index
            subSet(array, target, index -1);
        }
    }

    public static void main(String[] args) {
        QuestionTwo q = new QuestionTwo();
        int[] array = {2, 8, 11, 23 ,32, 4};
        int target = 2;
        int index = array.length - 1;
        q.subSet(array, target, index);
        System.out.println(q.result);
    }

}
