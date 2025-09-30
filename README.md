# hospital-patient-queue-system-using-java
Imagine you're a hospital administrator at "Medi-Care General Hospital". You need to design a system to manage incoming patients. Patients arrive with different conditions, and their treatment priority isn't simply based on who arrived first. Instead, it's based on the severity of their condition.
Your task is to create a system that can handle patient check-ins and check-outs. The system should prioritize patients based on their condition severity, represented by a numerical value. A lower number indicates a more critical condition and a higher priority (e.g., a patient with severity 1 needs to be seen before a patient with severity 3). If two patients have the same severity level, the one who checked in first should be seen first.
Design a patient queue system that can efficiently perform the following operations:
•	Check-in: A new patient arrives with a name and a severity level. They should be added to the queue according to the described priority rules.
•	Check-out: The doctor is ready to see the next patient. The system should identify and remove the patient with the highest priority (the most critical one) from the queue.
•	Display: Show the current list of patients in the queue, ordered by priority.
