import React,{useState} from 'react';

import MoviesList from './components/MoviesList';
import './App.css';

function App() {
   const [movies,setMovies] = useState('');
   const [isLoading,setIsloading] = useState(false);
   const [error,setError] = useState(null);
  const fetchMovies = () => {
      console.log("fetching movies...");
      setIsloading(true);
      fetch('https://swapi.dev/api/films/')
      .then(response => {
      console.log('Response received: ',response.status)
      if(!response.ok){
        setError(error);
        throw new Error('Error found');
        return;
      }
      return response.json();
      })
      .then(responsejson => {
          const movieList = responsejson.results.map(movie => {
            return {
              id: movie.episode_id,
              title: movie.title,
              openingtext: movie.opening_crawl,
              releaseDate: movie.release_date
            }
          });
          setIsloading(false);
          setMovies(movieList);
          console.log('movieList',movieList);
      })
      .catch(error => {
        console.log('Error =======>',error.TypeError);
        setIsloading(false);
        setError(error);
      });
  }

  return (
    <React.Fragment>
      <section>
        <button onClick={fetchMovies}>Fetch Movies</button>
      </section>
      <section>
      {!isLoading && movies.length!=0 && error==null && <MoviesList moviess={movies} />}
      {isLoading && error==null &&  <p>Loading...</p>}
      {!isLoading && movies.length===0  && error==null && <p>No Movies...</p>}
      {error!=null && <p>Some Error occured...</p>}
      </section>
    </React.Fragment>
  );
}

export default App;
// 