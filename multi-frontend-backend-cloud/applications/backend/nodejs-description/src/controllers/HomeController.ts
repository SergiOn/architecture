import { Request, Response } from 'express-serve-static-core';

export namespace HomeController {

  export const getHome = (req: Request, res: Response) => {
    res.status(200).send('Home Page: NodeJS');
  };

}
