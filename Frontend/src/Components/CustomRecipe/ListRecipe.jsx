import axios from 'axios';
import React from 'react'
import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';


export default function ListRecipe() {
    const [itemList, setList] = useState(null); //declaring useState


    React.useEffect(() => { //Calling  one api using async axios request function; also using useEffect.
        axios.get("https://ddsbbackend.herokuapp.com/recipes").then((response) => {
            const recipeList = (response.data.map((recipe) => {
                //Creating a dessert card for each meal using the map function.
                return (
                    <div className="card w-75 m-4" style={{ minWidth: "640px" }}>
                        <div className="card-body">
                            <h5 class="card-title">{recipe.recipeTitle}</h5>
                            <p class="card-text"><p>{recipe.recipeIngrd}</p>
                                <p>{recipe.recipeDesc}</p></p>
                            <Link to={`/showrecipe/${recipe.recipeId}`} className="btn btn-dark">View Recipe</Link>
                        </div>

                    </div>


                )
            }))

            setList(recipeList);

            console.log(response.data);
        }
        )

    }, [])
    return (
        <div className="text-center">
            <div className="d-flex justify-content-center">
                <div className="">{itemList}</div>

            </div>
        </div>
    )
}
