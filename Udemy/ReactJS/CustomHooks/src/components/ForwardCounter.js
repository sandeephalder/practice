
import useCounter from './hooks/use-counter';
import Card from './Card';

const ForwardCounter = () => {
  const fwcounter = useCounter(counter => counter+1);
  return <Card>{fwcounter}</Card>;
};

export default ForwardCounter;
