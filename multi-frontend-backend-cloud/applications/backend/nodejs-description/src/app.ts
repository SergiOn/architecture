import express from 'express';
import { DescriptionController } from 'controllers/DescriptionController';

// Create Express server
const app = express();

// Express configuration
app.set('port', process.env.PORT || 4302);

/**
 * Primary app routes.
 */
app.get('/', DescriptionController.getDescription);
app.get('/description', DescriptionController.getDescription);

export { app };
