import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';


const ShowRecipe = () => {
    const { id } = useParams();

    const [recipeTitle, setRecipeTitle] = useState(null);
    const [recipeIngrd, setRecipeIngrd] = useState(null);
    const [recipeDesc, setRecipeDesc] = useState(null);
    let navigate = useNavigate();

    //Calling the second api
    useEffect(() => {

        axios.get(
            `https://ddsbbackend.herokuapp.com/recipes/${id}`).then((response) => {
                console.log(response.data);
                setRecipeTitle(response.data.recipeTitle)
                setRecipeIngrd(response.data.recipeIngrd)
                setRecipeDesc(response.data.recipeDesc)

            })


            .catch(error => {
                console.log(error);
            })


    }, [id])

    function deleteRecipe(id) {
        axios.delete(`https://ddsbbackend.herokuapp.com/recipes/${id}`).then(res => {
            navigate("/listrecipe");

        }).catch(error => {
            console.log(error);
        })
    }

    return (
        //includes conditional rendering
        <div className="align-middle" style={{ display: "block", overflow: "auto" }}>
            <h2>{recipeTitle}</h2>
            <p>{recipeIngrd}</p>
            <p>{recipeDesc}</p>
            <button type="button" className="btn btn-danger mx-2" onClick={() => {
                deleteRecipe(id)
            }}>Delete Recipe</button>
            <button type="button" className="btn btn-dark mx-2" onClick={() => {
                navigate("/updaterecipe/" + id)
            }}>Edit Recipe</button>
        </div>
    )
}

export default ShowRecipe;