import { TestBed } from '@angular/core/testing';

import { GreetingService } from 'src/app/greeting/greeting.service';

describe('GreetingService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GreetingService = TestBed.get(GreetingService);
    expect(service).toBeTruthy();
  });
});
