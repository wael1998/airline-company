const express = require("express");
const PiloteController = require("../controllers/Pilote");


const { body, validationResult } = require("express-validator");
const PiloteRoutes = express.Router();

PiloteRoutes.route("/").get(PiloteController.getPilote);
PiloteRoutes.post(
  "/add",
  PiloteController.createPilote
);
PiloteRoutes.patch("/:id", PiloteController.updatePilote);
PiloteRoutes.delete("/:id", PiloteController.deletePilote);

module.exports = PiloteRoutes;
