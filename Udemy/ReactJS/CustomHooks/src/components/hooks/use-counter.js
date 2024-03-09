import { useState, useEffect } from 'react';

const useCounter = counterFunction => {
    const [counter, setCounter] = useState(0);

    useEffect(() => {
      const interval = setInterval(() => {
        setCounter(counterFunction);
      }, 1000);
  
      return () => clearInterval(interval);
    }, []);

    return counter;
  
}

export default useCounter;