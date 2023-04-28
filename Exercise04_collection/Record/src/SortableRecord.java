public class SortableRecord extends Record implements Comparable<SortableRecord>{
    public int getTotalScore(){return score_total;}

    public SortableRecord  (String id, int m, int j, int e){
        super(id, m, j, e);
    }

    public int compareTo(SortableRecord n){
        if(this.score_total < n.getTotalScore()){
            return 1;
        }
        else if(this.score_total == n.getTotalScore()) return 0;
        else return -1;
    }
}
