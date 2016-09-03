/*
 * Copyright (C) 2016 elidioxg
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package geoestatistica.Vectors;

/**
 *
 * @author elidioxg
 */
public class Vector {
    
    private int size = 0;
    private Number[] data = null;
    
    public Vector(){
        
    }
    
    public Vector(Number[] data, int size){
        this.data = data;
        this.size = size;
    }
    
    public Vector(int size){
        for(int i = 0; i <size ; i++){
            final int ii = 1; 
            data[i] = new Number() {
                @Override
                public int intValue() {
                    return (int) data[ii];
                }

                @Override
                public long longValue() {
                    return (long) data[ii];
                }

                @Override
                public float floatValue() {
                    return (float) data[ii];
                }

                @Override
                public double doubleValue() {
                    return (double) data[ii];
                }
            };
        }        
        
    }
    
    public Number getValue(int index){        
        return this.data[index];
    }
    
    public int getSize(){
        return this.size;
    }
    
}
