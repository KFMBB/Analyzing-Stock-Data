import java.util.Date;

public class NumericTimeSeriesImp implements NumericTimeSeries{
    TimeSeries<Double> TimeSeries;

    public NumericTimeSeriesImp()
    {
        TimeSeries = new TimeSeriesImp<Double>();
    }

//This is Just a TEST for this commit
    @Override
    public NumericTimeSeries calculateMovingAverage(int period)
    {    if (period <= 0 || TimeSeries.empty())
             return new NumericTimeSeriesImp(); // Return empty if invalid period or the series is empty.

        NumericTimeSeries result = new NumericTimeSeriesImp();
        DLL<DataPoint<Double>> allDataPoints = TimeSeries.getAllDataPoints();
        int dataSize = allDataPoints.size();

        if (dataSize < period) // If there are fewer data points than the period return an empty series.
            return result;

        allDataPoints.findFirst();
        double sum = 0;
        // calc the sum with first period data points
        for (int i = 0; i < period; i++) {
            sum += allDataPoints.retrieve().value;
            if (i < period - 1) // Prevent findNext on the last iteration
                allDataPoints.findNext();
        }
        // calc the first average
        double average = sum / period;
        result.addDataPoint(new DataPoint<Double>(allDataPoints.retrieve().date, average));

        // move the window and calculate the moving average for the rest of the data points
        allDataPoints.findFirst(); // reset to the first element
        for (int i = 0; i < dataSize - period; i++) {
            sum -= allDataPoints.retrieve().value; // subtracting the value of the first element of the window

            for (int j = 0; j < period; j++) // advancing to the last element of the new window
                allDataPoints.findNext();

            sum += allDataPoints.retrieve().value; // add the new element entering the window

            average = sum / period;
            result.addDataPoint(new DataPoint<Double>(allDataPoints.retrieve().date, average));

            // navigate back to the correct position for the date of the next average
            for (int k = 0; k < period - 1; k++)
                allDataPoints.findPrevious();
        }
        return result;
    }

    @Override
    public DataPoint<Double> getMax()
    {
        if(TimeSeries.empty())
            return null;
        DLL<DataPoint<Double>> tmp = TimeSeries.getAllDataPoints();
        tmp.findFirst();
        DataPoint<Double> maxPoint = tmp.retrieve();
        Double max = tmp.retrieve().value;
        tmp.findNext();
        while(!tmp.last()){
            if(tmp.retrieve().value > max){
                maxPoint = tmp.retrieve();
                max = tmp.retrieve().value;
            }
            tmp.findNext();
        }
        if(tmp.retrieve().value > max){
            maxPoint = tmp.retrieve();
            max = tmp.retrieve().value;
        }
        return maxPoint ;
    }

    @Override
    public DataPoint<Double> getMin()
    {
        if(TimeSeries.empty())
                return null;

        DLL<DataPoint<Double>> tmp = TimeSeries.getAllDataPoints();
        tmp.findFirst();
        DataPoint<Double> minPoint = tmp.retrieve();
        Double min = tmp.retrieve().value;
        tmp.findNext();
        while(!tmp.last()){
            if(tmp.retrieve().value < min){
                minPoint = tmp.retrieve();
                min = tmp.retrieve().value;
            }
            tmp.findNext();
        }
        if(tmp.retrieve().value < min){
            minPoint = tmp.retrieve();
            min = tmp.retrieve().value;
        }
        return minPoint;
    }

    @Override
    public int size()
    {
        return TimeSeries.size();
    }

    @Override
    public boolean empty()
    {
        return TimeSeries.empty();
    }

    @Override
    public Double getDataPoint(Date date)
    {
        if (TimeSeries.getDataPoint(date) != null )
        {
            return TimeSeries.getDataPoint(date);
        }
        return 0.0;
    }

    @Override
    public DLL<Date> getAllDates()
    {
        return TimeSeries.getAllDates();
    }

    @Override
    public Date getMinDate()
    {
        return TimeSeries.getMinDate() ;
    }

    @Override
    public Date getMaxDate()
    {
        return TimeSeries.getMaxDate() ;
    }

    @Override
    public boolean addDataPoint(DataPoint<Double> dataPoint)
    {
        return TimeSeries.addDataPoint(dataPoint) ;
    }

    @Override
    public boolean updateDataPoint(DataPoint<Double> dataPoint)
    {
        if ( TimeSeries.getDataPoint(dataPoint.date) != null ) {
            TimeSeries.updateDataPoint(dataPoint) ;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDataPoint(Date date)
    {
        return TimeSeries.removeDataPoint(date) ;
    }

    @Override
    public DLL<DataPoint<Double>> getAllDataPoints()
    {
        return TimeSeries.getAllDataPoints() ;
    }

    @Override
    public DLL<DataPoint<Double>> getDataPointsInRange(Date startDate, Date endDate)
    {
      return TimeSeries.getDataPointsInRange(startDate, endDate) ;
    }
    public void display() {
        ((TimeSeriesImp) TimeSeries).display();

    }





}
