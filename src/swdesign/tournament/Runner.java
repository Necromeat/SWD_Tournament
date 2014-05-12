/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign.tournament;

import static java.lang.Runtime.getRuntime;
import java.util.concurrent.Executor;

/**
 *
 * @author Andrew
 */
public class Runner implements  Executor{
    Runtime r = getRuntime();
    Executor[] services = new Executor[r.availableProcessors()];
  
    @Override
    public void execute(Runnable  r) {
        r.run();
      
    }

    
   
    
}
