import React from 'react';
import SearchResult from "./search-result";

const SearchResults = (props) => (
    <div>
        {props.results.map(i => {
                console.log(i.value)
                return <SearchResult key={i.id} value={i.value}/>;
            })}
    </div>
);

export default SearchResults;