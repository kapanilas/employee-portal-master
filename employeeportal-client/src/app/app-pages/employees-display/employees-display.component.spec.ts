import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { EmployeesDisplayComponent } from './employees-display.component';


describe('EmployeesDisplayComponent', () => {
  let component: EmployeesDisplayComponent;
  let fixture: ComponentFixture<EmployeesDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeesDisplayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeesDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

});
