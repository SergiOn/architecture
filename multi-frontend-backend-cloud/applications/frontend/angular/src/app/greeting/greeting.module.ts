import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatListModule, MatProgressSpinnerModule } from '@angular/material';
import { GreetingComponent } from './greeting.component';
import { GreetingService } from './greeting.service';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    MatButtonModule,
    MatListModule,
    MatProgressSpinnerModule,
  ],
  declarations: [
    GreetingComponent,
  ],
  providers: [
    GreetingService,
  ],
  exports: [
    GreetingComponent,
  ],
})
export class GreetingModule { }
