import React from 'react';

import Movie from './Movie';
import classes from './MoviesList.module.css';

const MovieList = (props) => {
  const movies = [...props.moviess];
  console.log('MovieLists ==> ',movies);
  if (movies.length ==0){
    return (
      <ul className={classes['movies-list']}>
       
      </ul>
    );
  }
  else
  {
    return (
      <ul className={classes['movies-list']}>
       {movies.map((movie) => (
        <Movie
          key={movie.id}
          title={movie.title}
          releaseDate={movie.releaseDate}
          openingText={movie.openingText}
        />
      ))}
      </ul>
    );
  }
  
};

export default MovieList;
 /**/