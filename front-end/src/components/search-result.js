import React from 'react';

import {resultSelect} from "../actions/index";

const SearchResult = function (props) {
    return <div onClick={resultSelect(props)}>{props.value}</div>
};

export default SearchResult;