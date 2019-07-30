import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccommodationSsrComponent } from './accommodation-ssr.component';

describe('AccommodationSsrComponent', () => {
  let component: AccommodationSsrComponent;
  let fixture: ComponentFixture<AccommodationSsrComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccommodationSsrComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccommodationSsrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
