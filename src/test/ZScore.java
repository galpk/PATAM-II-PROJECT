package test;


import java.util.ArrayList;
import java.util.List;

public class ZScore implements TimeSeriesAnomalyDetector {

    public static class MaxCol{
        public String Colname;
        float MaxNum;
        public MaxCol(String name , Float num)
        {
            this.Colname = name;
            this.MaxNum = num;
        }
    }
    private List<MaxCol> ThresholdList ;
    @Override
    public void learnNormal(TimeSeries ts) {
        ThresholdList = new ArrayList<>();
        float avg;
        float var;
        float zs , max=0;
        MaxCol mc;
        for (int i=0; i < ts.Dtable.size(); i++){
            avg = StatLib.avg(ts.help(ts.Dtable.get(i).Vlist));
            var = (float)Math.sqrt(StatLib.var(ts.help(ts.Dtable.get(i).Vlist)));
            for (int j = 0; j < ts.Dtable.get(i).Vlist.size(); j++){
                zs = Math.abs(ts.Dtable.get(i).Vlist.get(j) - avg)/var;
                if (zs > max)
                {
                    max =zs;
                }
            }
        mc = new MaxCol(ts.Dtable.get(i).Fname,max);
        ThresholdList.add(mc);
        }
    }

    @Override
    public List<AnomalyReport> detect(TimeSeries ts) {

        float avg;
        float var;
        float zs , max=0;
        float [] ZsMaxArr;
        for (int i=0; i < ts.Dtable.size(); i++){
            avg = StatLib.avg(ts.help(ts.Dtable.get(i).Vlist));
            var = (float)Math.sqrt(StatLib.var(ts.help(ts.Dtable.get(i).Vlist)));
            for (int j = 0; j < ts.Dtable.get(i).Vlist.size(); j++){
                zs = Math.abs(ts.Dtable.get(i).Vlist.get(j) - avg)/var;
                if (zs > max)
                {
                    max =zs;
                }

            }
           for (int i= 0 ; i < ThresholdList.size(); i++){
               if ((max > ThresholdList.get(i))
           }
        }

        return  null;
    }
}
