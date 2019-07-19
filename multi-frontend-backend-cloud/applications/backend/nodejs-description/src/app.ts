import express from 'express';
import { HomeController } from 'controllers/HomeController';
import { DescriptionController } from 'controllers/DescriptionController';

// Create Express server
const app = express();

// Express configuration
app.set('port', process.env.PORT || 4302);

/**
 * Primary app routes.
 */
app.get('/', HomeController.getHome);
app.get('/description', DescriptionController.getDescription);

export { app };
