public class Sound {

/* the array of values in this sound; guaranteed not to be null */
private int[] samples;

    /* constructor not shown */

    /* Changes those values in this sound that have an amplitude
    * greater than limit. Values greater than limit are changed to
    * limit. Values less than -limit are changed to -limit.
    * The method returns the total number of values that were changed
    * in the array.
    *
    * PRECONDITION: limit ≥ 0
    */

    public Sound(int[] samples) {
        this.samples = samples;
    }
    
    
    public int[] getSamples() {
        return samples;
    }
        
    public int limitAmplitude(int limit) {
        int count = 0;
        for (int i = 0; i < samples.length; i++) {
            if (Math.abs(samples[i]) > limit) {
                if (samples[i] > 0) {
            samples[i] = limit;
                } else {
                    samples[i] = limit * (-1);
                }
            count++;
            }
        }
        return count;    
    }

/* Removes all silence from the beginning of this sound.
    * Silence is represented by a value of 0.
    *
    * PRECONDITION: samples contains at least one nonzero value
    *
    * POSTCONDITION: the length of samples reflects the removal
    *                of starting silence
    */
    public void trimSilenceFromBeginning() {
        int idx = 0;
        while (samples[idx] == 0) {
            idx++;
        }
        int[] tempList = samples;
        samples = new int[tempList.length - idx];
        for (int i = 0; i < samples.length; i++) {
            samples[i] = tempList[i + idx];
        }
    }
}

