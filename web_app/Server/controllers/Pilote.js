var Pilote = require("../models/Pilote");
const axios = require("axios");
const mongoose = require("mongoose");
const { body, validationResult } = require("express-validator");

const getPilote = async (req, res) => {
 
 
  axios.get('http://localhost:8081/api/pilotes',{
    data: {},
  }).then(resp => {
    res.status(200).json(resp.data)
  
})
.catch(function (error) {
  console.log(error);
})

};

const createPilote = async (req, res) => {
  var newPilote = new Pilote();
  newPilote.id = req.body.id;
  newPilote.capacite = req.body.capacite;
  newPilote.type = req.body.type;
  newPilote.constructeur = req.body.constructeur;


  axios.post('http://localhost:8081/api/pilotes', newPilote)
  .then(response =>  res.status(200).json(newPilote))
  .catch(error => {
      console.error('There was an error!', error);
  });
};

const updatePilote = async (req, res) => {
  const { id } = req.params;
  axios.put(`http://localhost:8081/api/pilotes/${id}`, {
     id: req.body.id,
     capacite: req.body.capacite,
     type: req.body.type,
     constructeur: req.body.contructeur
  })
  .then(response => {
    console.log(response);
  })
  .catch(error => {
    console.log(err);
  });
};

const deletePilote = async (req, res) => {
  const { id } = req.params;

  axios.delete(`http://localhost:8081/api/pilotes/${id}`);
  res.json({ message: "Pilote deleted successfully." });
};

module.exports = { getPilote: getPilote, createPilote, updatePilote, deletePilote };